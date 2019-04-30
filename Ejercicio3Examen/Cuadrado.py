#!/usr/bin/env python
# -*- coding: utf-8 -*-
from Ejercicio3Examen.Rectangulo import Rectangulo

class Cuadrado(Rectangulo):
    def __init__(self, l):
        super().__init__(l, l)
        self.lado = l

    def get_lado(self):
        return self.lado

    def set_lado(self, l):
        if(self.lado<=0):
            raise ArithmeticError("El lado no puede ser igual o menor a 0")
        elif(self.lado>10):
            raise ArithmeticError("El lado no puede ser mayor que 10")
        self.lado=l

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
