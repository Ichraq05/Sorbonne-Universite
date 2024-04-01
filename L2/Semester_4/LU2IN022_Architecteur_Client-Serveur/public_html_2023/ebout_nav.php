<?php

function ebout_nav(array $cat){
    $result="";
    foreach($cat as $id_cat => $libelle){
        $result .= "<li><button onclick='ebout_ajax_post(\"$id_cat\")'>"
                . $libelle
                . "</button></li>\n";
    }
    return "<ul class='nav'>$result</ul>";
}