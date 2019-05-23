#!/usr/bin/env python
# -*- coding: utf-8 -*-
'''
3.- Crea la clase Rectángulo de forma que:
• Un objeto de esta clase se construye pasándole el ancho y el alto. Ninguno de los dos atributos
puede ser menor o igual a cero ni mayor que diez, en esos casos se debe lanzar la excepción
ArithmeticException.
• Mediante getters y setters permite que se acceda y se modifique el ancho y el alto del
rectángulo teniendo en cuenta las restricciones en cuanto a las dimensiones del apartado
anterior.
• Al imprimir en pantalla un objeto de la clase usando System.out.print se debe dibujar el
rectángulo por la pantalla (de manera similar a como se imprime un cuadrado en la página 130
del libro Aprende Java con Ejercicios).
• Crea la clase Cuadrado como subclase de Rectángulo. Le debes añadir a su comportamiento
la posibilidad de comparar objetos cuadrados entre sí.
• Crea los programas de test correspondientes a ambas clases. Debes provocar que se lance la
excepción y capturarla.
'''


class Rectangulo:

    def __init__(self, ancho, alto):
        self.__ancho = ancho
        self.__alto = alto

   @property
    def ancho(self):
        return self.__ancho
    
    @ancho.setter
    def ancho(self, ancho):
        Rectangulo.__verifica_lado(ancho)
        self.__ancho = ancho

    @property
    def alto(self):
        return self.__alto
    
    @alto.setter
    def alto(self, alto):
        Rectangulo.__verifica_lado(alto)
        self.__alto = alto
        
'''
    verificarLado
'''

    @staticmethod
    def __verifica_lado(num):
        if not isinstance(num, int):  # lado no entero
            raise TypeError("Lado no entero", num)  # Lanzo esta excepcion si el parametro introducido no es un entero.
        if (num <= 0 or num > 10):
            raise ArithmeticError()  # Lanzo esta excepcion que es similar al ArithmeticException de Java

    def __str__(self):
        resultado = ""
        # Parte superior del cuadrado
        for i in range(self.ancho):
            resultado += "**"
        resultado += "\n"
        # Parte media del cuadrado
        for i in range(1,self.alto - 1):
            resultado += "**"
            for espacios in range(1,self.ancho - 1):
                resultado += "  "
            resultado += "**\n"
        # Parte inferior del cuadrado
        for i in range(self.ancho):
            resultado += "**"
        resultado += "\n"
        return resultado
