Si por alguna razón necesitamos conectarnos a un servidor MySQL desde nuestra aplicación Android, lo más aconsejable y seguro es utilizar un archivo PHP alojado en el servidor en cuestión que acceda a la base de datos y devuelva la información a la aplicación, por ejemplo en JSON u otro formato similar.

Si no podemos hacer esto, tenemos la opción de utilizar un driver JDBC, como hariamos en una aplicación java. Para ello seguiremos los siguientes pasos:

Descargamos el driver desde aquí: http://dev.mysql.com/downloads/connector/j/3.0.html
Creamos en nuestro proyecto una carpeta llamada “libs”.
Descomprimimos el archivo indicado y lo copiamos en la carpeta libs.
Añadimos el jar al build Path, para ello:
Clic derecho en el proyecto >  Build Path >Configure Build Path
Pestaña Libraries >  Add JAR
Busca la carpeta libs y selecciona el archivo Jar.
Una vez está el driver listo, pasamos a la parte de programación. Como sabemos, Android obliga a hacer las operaciones de acceso a red en un hilo independiente, por tanto debemos elegir una de las formas habituales de crear un nuevo hilo. Por ejemplo, con un AsynkTask. En ese caso añadiríamos este código al método doInBackground.

 

private static final String url = “jdbc:mysql://{URL_SERVER}/{BASE_DATOS}”;
private static final String user = “usuario”;
private static final String password = “contraseña”;
int count = 0;
try {
//con esto nos aseguramos de que se crean los recursos estaticos necesarios
Class.forName(“com.mysql.jdbc.Driver”).newInstance();
Connection con = DriverManager.getConnection(url, user, password);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(“QUERY A EJECUTAR”);
while (rs.next()) {

publishProgress(++count);
// Terminar lo antes posible si se ha llamadao al cancel() del asynctask
if (isCancelled()) {
break;
}
}
catch (Exception e) {
e.printStackTrace();
}

}
