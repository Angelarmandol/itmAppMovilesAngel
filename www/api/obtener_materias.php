<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require 'materia.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    // Manejar petición GET
    $materias = materia::getAll();

    if (true) {

        $datos["id_Materia"] = 1;
        $datos["Nombre"] = $materias;

        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}