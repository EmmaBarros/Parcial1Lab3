/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author emami
 * @param <T>
 */
public interface IGestionable<T> {
    
    void registrar(T elem);
    T buscar(T elem);
    void eliminar();
    void mostrarListado();
}
