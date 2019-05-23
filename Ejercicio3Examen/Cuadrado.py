#!/usr/bin/env python
# -*- coding: utf-8 -*-
from Ejercicio3Examen.Rectangulo import Rectangulo

class Cuadrado(Rectangulo):
    def __init__(self, lado):
        super().__init__(lado, lado)

    def lado(self):
        return self.ancho
    
    @lado.setter
    def lado(self, lado):
        self.alto = lado
        self.ancho = lado

    '''Sobrecarga de operadores >'''
    def __gt__(self, other):
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) > (other.lado)

    def __ge__(self, other):
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) >= (other.lado)

    def __eq__(self, other):
        if not isinstance(other, Cuadrado):
            raise Exception
        else:
            return (self.lado) == (other.lado)


if __name__ == "__main__":
    try:
        c1 = Cuadrado(4)
        c2 = Cuadrado(10)
        print('c1>c2'+str(c1>c2))
    except ArithmeticError as e:
        print(e)
