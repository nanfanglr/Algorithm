package com.rui.algorithm.symboltable;

import org.junit.Test;

public class SymbolTableTest {
    @Test
    public void testSymbolTable() {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(1, "one");
        symbolTable.put(2, "two");
        symbolTable.put(3, "three");
        symbolTable.put(4, "four");
        System.out.println("size = " + symbolTable.size());
        symbolTable.put(1, "oonee");
        System.out.println("1 = " + symbolTable.get(1));
        symbolTable.delete(4);
        System.out.println("size = " + symbolTable.size());
        System.out.println("4 = " + symbolTable.get(4));
    }
    @Test
    public void testOrderSymbolTable() {
        OrderSymbolTable<Integer, String> symbolTable = new OrderSymbolTable<>();
        symbolTable.put(2, "two");
        symbolTable.put(1, "one");
        symbolTable.put(4, "four");
        symbolTable.put(3, "three");

    }
}
