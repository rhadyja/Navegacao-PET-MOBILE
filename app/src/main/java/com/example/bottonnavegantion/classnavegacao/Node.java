package com.example.bottonnavegantion.classnavegacao;

public class Node <T> {

    T informacao;
    Node<T> proximo;

    public Node(T novo) {
        this.informacao = novo;
    }
}
