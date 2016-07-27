/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class GenericMain {
    
    public static < T extends Shape > void draw ( T shape ) {
        shape.draw();
    }

    public static void main(String[] args) {
        Foo< String> stbox = new Foo< String>();
        Foo< Integer> itbox = new Foo< Integer>();

        NonGenericStack nonGenericStack = new NonGenericStack();
        GenericStack< String> gs = new GenericStack< String>();
        GenericStack< Integer> igs = new GenericStack< Integer>();

        Comparator< String, Integer, Double> cmp = new CompareToGeneric();

        List< String> list = new ArrayList< String>();
        Integer[] arr = {5, 1, 3, 4, 2};
        String[] str = {"World", "Hello"};

        GenericQueue< String> genericqueue = new GenericQueue< String>();

        nonGenericStack.push("Ram");
        nonGenericStack.push("Sam");
        nonGenericStack.push(2441139);

        gs.push("Generic Stack");
        igs.push(465);

        stbox.setObj("Box Sample");
        itbox.setObj(10);

        list.add("Geometry");
        list.add("Combinatorics");
        list.add("Algebra");
        list.add("Trigonomiti");

        genericqueue.enqueue("Jodu");
        genericqueue.enqueue("Modu");
        genericqueue.enqueue("Kodu");
        genericqueue.enqueue("Nodu");

//        System.out.println(stbox.getObj());
//        System.out.println(itbox.getObj());
//
//        System.out.println(nonGenericStack.pop());
//        System.out.println(nonGenericStack.pop());
//        System.out.println(nonGenericStack.pop());
//
//        System.out.println(gs.pop());
//        System.out.println(igs.pop());
//
//        System.out.println(cmp.compareToStr("Abdur", "Razzak"));
//        System.out.println(cmp.compareToInt(5, 3));
//        System.out.println(cmp.compareToDou(2.5, 2.5));
//        
//        System.out.println( GenericMethod.FindElementInlist("Algebra", list) );
//        GenericMethod.Swap( arr, 0, 2);
//        GenericMethod.Swap( str, 0, 1);
//        GenericMethod.Sort(arr);
//        
//        for ( int i = 0; i < 5; i++ )
//            System.out.println( arr[i] );
//        System.out.println( Arrays.toString(str) );

//        System.out.println(genericqueue.dequeue());
//        System.out.println(genericqueue.dequeue());
//        System.out.println(genericqueue.isEmpty());

      //  GenericWildCard.PrintCollection(list);
      
//      Bounded WildCard Example
        
        Rectangle rec = new Rectangle();
        Circle cir = new Circle();
    
        draw(rec);
        draw(cir);
    }
}
