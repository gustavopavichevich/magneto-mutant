################################mutant - DISENO INTERNO####################################

#Objetivo del requerimiento:

Para eso te ha pedido crear un programa con un metodo o funcion con la siguiente firma (En
alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

boolean isMutant(String[] dna); // Ejemplo Java

En donde recibiras como parametro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

#Alcance del Requerimiento:
Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar un mutante, deberia devolver un HTTP 200-OK, en caso contrario un
403-Forbidden.
Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}

#Fuera del alcance:
Presentación de los casos de prueba y los Test automaticos. Si bien fueron realizado como pruebas unitarias para la entrega del desarrollo en produccion no se entregan evidencias.

#Premisas y Supuestos:
Partimos de la premisa que tenemos disponbles la contratacion del hosting donde se alojara la apli rest. 

#Descripcion Funcional de la Solución:
Se gestiona la creacion de una api rest. La construccion y solución del proyecto fue pensada en java, a traves del framework springboot. Para almacenamiento de datos se utilizo una base de datos relacional mysql. Para exponer el servicio rest utilice HEROKU, de Salesforce. Ya que tenia la posibilidad de avanzar con estas tecnologías de manera free. 

Para la ejecutar el servicio '/mutant/' se debera invocar la siguiente url:	
https://mutant-app.herokuapp.com/mutant
Invocandolo mediante la estructura modelo JSon:
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
Para invocar el servicio '/stats/':
https://mutant-app.herokuapp.com/stats
Sin parametros de entrada. Podria haberse hecho mediante un metodo GET pero ya que el Sr Magneto no especifico como consultarlo lo hice POST para continuar con las consideraciones genericas del pedido. 
Este ultimo servicio retorna un Json en el que figura la cantidad de ADNs analizados. Separados en los que fueron identificados como humanos y como mutantes. Adicionalmente, se muestra un "ratio" qeu es el porcentaje de ocurrencias de ADNs mutantes almacenadas contra todos los ingresos a la base de datos:
{
    "ADN": "{"count_human_dna":"10","count_mutant_dna":"5","ratio":0.5}"
}
