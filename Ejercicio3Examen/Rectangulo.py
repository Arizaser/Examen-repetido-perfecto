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

    def __init__(self, alt, anch):
        self.alto=alt
        self.ancho=anch
        self.set_alto(alt)
        self.set_ancho(anch)

    def get_ancho(self):
        return self.ancho

    def get_alto(self):
        return self.alto

    def set_ancho(self, anch):
        if(self.ancho<=0):
            raise ArithmeticError("El ancho no puede ser igual o menor a 0")
        elif(self.ancho>10):
            raise ArithmeticError("El ancho no puede ser mayor que 10")
        self.ancho=anch

    def set_alto(self, alt):
        if (self.alto <= 0):
            raise ArithmeticError("El alto no puede ser igual o menor a 0")
        elif (self.alto > 10):
            raise ArithmeticError("El alto no puede ser mayor que 10")
        self.alto = alt

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
