<h1 style="text-align:center;">API RESTful Creación de Usuarios - Prueba NISUM</h1>
<p style="text-align:center;"><strong>Autor</strong>: Miguel Angel Garces</p>
<h2>Descripción:</h2>
<p>API que expone un endpoint para la creación de usuarios, acepta y retorna parámetros en formato JSON. Recibe campos como: Nombre completo, email, password, teléfonos. Usa anotaciones para las validaciones de parametros de entrada y persiste la información en una base de datos en memoria H2. Los mensajes de error tipo JSON y el HTTP status son retornados como salida del servicio.</p>
<h2>Tecnologías/Frameworks Utilizados</h2>
<figure class="table">
    <table>
        <tbody>
            <tr>
                <td>
                    <ul>
                        <li>Framework Spring boot</li>
                        <li>Java17</li>
                        <li>Maven</li>
                        <li>H2</li>
                        <li>JPA/Hibernate</li>
                        <li>Modelo MVC</li>
                    </ul>
                </td>
                <td>
                    <ul>
                        <li>Swagger (OpenAPI)</li>
                        <li>JWT</li>
                        <li>GIT</li>
                        <li>Junit/mockito</li>
                        <li>IntelliJ</li>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
</figure>
<h2>Instrucciones Ejecución</h2>
<ol>
    <li>Clonar el repositorio de github <a target="_blank" rel="noopener noreferrer" href="https://github.com/sirmardok/api-rest-h2">https://github.com/sirmardok/api-rest-h2</a></li>
    <li>Usar un IDE como Eclipse, IntelliJ Idea para navegar el código</li>
    <li>Tener instalado Java 17 y Apache Maven 3.9.9 o superior para compilar y empaquetar</li>
    <li>Ejecutar aplicación “Run As…” → "Java Application</li>
    <li>Acceder a la aplicación desde Postman al URL: <a target="_blank" rel="noopener noreferrer" href="http://localhost:8080/api/users/create">http://localhost:8080/api/users/create</a></li>
    <li>Acceder a la consola de H2: <a target="_blank" rel="noopener noreferrer" href="http://localhost:8080/h2-ui">http://localhost:8080/h2-ui</a></li>
    <li>Acceder a la documentación de Swagger: <a target="_blank" rel="noopener noreferrer" href="http://localhost:8080/swagger-ui/index.html">http://localhost:8080/swagger-ui/index.html</a></li>
    <li>Acceso al diagrama de base de datos: <a target="_blank" rel="noopener noreferrer" href="https://dbdiagram.io/d/67f5c9944f7afba184dcac46">https://dbdiagram.io/d/67f5c9944f7afba184dcac46</a></li> 
    <li>En la carpeta "/Docs" se encuentra una colección de postman para ejecutar los endpoints y validar los errores</li>
</ol>
<h2>Ejemplo formato JSON (body)</h2>
<p><code><strong>POST → </strong>api/users/create</code></p>
<pre><code class="language-plaintext">{
  "name": "Migue Garces",
  "email": "sirmardok1@gmail.com",
  "password": "mardok2025",
  "phones": [
    {
      "number": "3195618139",
      "city": "1",
      "country": "57"              
    }
  ]
}</code></pre>
