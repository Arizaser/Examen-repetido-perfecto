#!/usr/bin/env python
# -*- coding: utf-8 -*-
from Ejercicio3Examen.Rectangulo import Rectangulo

try:
    r1 = Rectangulo(5, 9)
    print(r1)
except ArithmeticError as e:
    print(e)
