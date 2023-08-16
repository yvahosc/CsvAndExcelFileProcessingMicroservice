# Csv and Excel file processing microservice

## Desarrollo microservicio de procesamiento de archivos csv y Excel dentro del desarrollo del BootCamp de desarrollo web BackEnd de MAKAIA.

### Equipo de trabajo:
  * Paula Múnera
  * Yeisson Vahos

### El repositorio corresponde a parte de la respuesta al taller planteado:

### EJERCICIO PRACTICO.

#### Se requiere crear una solución la cual permita validar un archivo que puede ser (Excel, csv).
#### por lo tanto, se deberá generar un POST REQUEST (en el body se le enviará la ruta del archivo) para el servicio de procesar.

#### Objetivo del servicio de procesamiento:

##### Cargar el documento, para ser leído, una vez leído, por cada registro se debe enviar una petición POST al servicio de validación para validar si el registro está bien o no, el servicio de validación retornara un booleano indicando si el registro esta valido o no, una vez procesados todos los registros se debe retornar al usuario el número de líneas validas e invalidas.
##### Nota: la lectura y carga de un archivo csv, Excel son diferentes, tiene que hacer una implementación para cada una, tenga en cuenta que en el futuro se pueden añadir más tipos de archivos para validar, entonces debe de ser escalable la solución.

#### Objetivo del servicio de validación:

##### Si el archivo es CSV las validaciones deben de ser las siguientes.
* Validar si el email tiene la estructura correcta de un correo electrónico Ejemplo:
  - mateo@gmail.com -> correo valido
  - juan@example.com -> correo valido
  - asdasda878__ -> correo invalido
  - Juan””#@@..co -> correo invalido.
  - Para validar esto usar una expresión regular.
* Validar el Date of birth , se cuenta como linea valida si es mayor al 1980-01-01
* Validar el Job Title , si es Haematologist, Phytotherapist, Building surveyor, Insurance account manager, Educational psychologist, si es alguno de estas , se tomara como valida.
* Si no cumple con alguna de estas validaciones no se tomará la línea como valida, y retornara false al servicio.

##### Si el archivo es Excel las validaciones deben de ser las siguientes.
* Validar el Injury Location que sea diferente de N/A
* Validar el Report Type solo se deben aceptar (Near Miss, Lost Time, First Aid)
* Si no cumple con alguna de estas validaciones la línea queda marcada cono invalida, y retornara false al servicio.

![image](https://github.com/yvahosc/CsvAndExcelFileValidationMicroservice/assets/97228219/82b143f2-3a34-44ff-b721-e67130a8b170)

### En este microservicio se realiza el procesamiento de un archivo csv o Excel y se envían uno a uno los registros contenidos en él al servicio de validación  (el cual se encuentra en el repositorio https://github.com/yvahosc/CsvAndExcelFileValidationMicroservice) para verificar si este cumple las validaciones mencionadas anteriormente o no retornando al microservicio de procesamiento dicha información para que este realice un conteo de la cantidad de registros válidos e inválidos del archivo y finalmente entregar una respuesta que contiene la cantidad de registros inválido y válidos de dicho archivo.
### Para verificar la solución al ejercicio planteado es necesario descargar ambos microservicios, ejecutarlos y utilizar el archivo FileProcessorAndRecordValidator.postman_collection.json importarlo en postman y con el realizar las pruebas para verificar el funcionamiento de los microservicios.
