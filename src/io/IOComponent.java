/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io;
/**
 * Defines how to accept input/output.
 * @author Jeremy
 * @param <I> The object that it will accept input through.
 * @param <O> The object that it will output to.
 */
public interface IOComponent<I, O> {
    public O generateOutput(I input);
}
