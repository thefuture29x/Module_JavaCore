/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacore.practice.examples_wagu.set1;

import javacore.practice.wagu.Block;
import javacore.practice.wagu.Board;

/**
 *
 * @author Thedath Oudarya
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        Board board = new Board(75);
        String preview = board.setInitialBlock(new Block(board, 50, 12)).build().getPreview();
        System.out.println(preview);
    }    
}
