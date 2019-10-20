package com.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ventas.entity.Producto;
import com.ventas.entity.Detalle;
import com.ventas.entity.Factura;
import com.ventas.repository.ProductosRepository;
import com.ventas.repository.DetallesRepository;
import com.ventas.repository.FacturasRepository;
import com.ventas.util.ProductoVenta;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/facturar")
public class FacturasController {
    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private FacturasRepository ventasRepository;
    @Autowired
    private DetallesRepository productosVendidosRepository;

    @PostMapping(value = "/quitar/{indice}")
    public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
        ArrayList<ProductoVenta> carrito = this.obtenerCarrito(request);
        if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
            carrito.remove(indice);
            this.guardarCarrito(carrito, request);
        }
        return "redirect:/facturar/";
    }

    private void limpiarCarrito(HttpServletRequest request) {
        this.guardarCarrito(new ArrayList<>(), request);
    }

    @GetMapping(value = "/limpiar")
    public String cancelarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        this.limpiarCarrito(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/facturar/";
    }

    @PostMapping(value = "/terminar")
    public String terminarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProductoVenta> carrito = this.obtenerCarrito(request);
        if (carrito == null || carrito.size() <= 0) {
            return "redirect:/facturar/";
        }
        Factura  v = ventasRepository.save(new Factura());   
        for (ProductoVenta productoVenta : carrito) {
            Producto p = productosRepository.findById(productoVenta.getId()).orElse(null);
            if (p == null) continue; 
            p.restarExistencia(productoVenta.getCantidad());
            productosRepository.save(p);
            Detalle productoVendido = new Detalle(productoVenta.getCantidad(), productoVenta.getPrecio(), productoVenta.getNombre(), productoVenta.getCodigo(), v, p );
            productosVendidosRepository.save(productoVendido);
        }

        this.limpiarCarrito(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta Exitosa")
                .addFlashAttribute("clase", "success");
        return "redirect:/facturar/";
    }

    @GetMapping(value = "/")
    public String interfazVender(Model model, HttpServletRequest request) {
        model.addAttribute("producto", new Producto());
        float total = 0;
        ArrayList<ProductoVenta> carrito = this.obtenerCarrito(request);
        for (ProductoVenta p: carrito) total += p.getTotal();
        model.addAttribute("total", total);
        return "facturar/facturar";
    }

    private ArrayList<ProductoVenta> obtenerCarrito(HttpServletRequest request) {
        ArrayList<ProductoVenta> carrito = (ArrayList<ProductoVenta>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }

    private void guardarCarrito(ArrayList<ProductoVenta> carrito, HttpServletRequest request) {
        request.getSession().setAttribute("carrito", carrito);
    }

    @PostMapping(value = "/agregar")
    public String agregarAlCarrito(@ModelAttribute Producto producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProductoVenta> carrito = this.obtenerCarrito(request);
        Producto productoBuscadoPorCodigo = productosRepository.findFirstByCodigo(producto.getCodigo());
        if (productoBuscadoPorCodigo == null) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "Producto con codigo " + producto.getCodigo() + " No existe")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/facturar/";
        }
        if (productoBuscadoPorCodigo.sinExistencia()) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "Producto agotado")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/facturar/";
        }
        boolean encontrado = false;
        for (ProductoVenta productoVentaActual : carrito) {
            if (productoVentaActual.getCodigo().equals(productoBuscadoPorCodigo.getCodigo())) {
                productoVentaActual.aumentarCantidad();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            carrito.add(new ProductoVenta(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getId(), 1f));
        }
        this.guardarCarrito(carrito, request);
        return "redirect:/facturar/";
    }
}
