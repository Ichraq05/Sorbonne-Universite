<?php

include 'debut_html.php';
include 'init_responsive.php';
include 'choisir_style.php';

$media = array('all', 'print', 'screen', 'handheld');
$styles = array('all.css','all2.css','handheld.css','print.css','screen.css');
$tab = array();

foreach($media as $v){
    if(!isset($_POST[$v])){
        $tab[$v] = isset($_COOKIE[$v]) ? $_COOKIE[$v] : 0;
    }
    else{
        $tab[$v] = $_POST[$v];
        setcookie($v, $_POST[$v], ['samesite' => 'Strict']);
    }
}

$choix = init_responsive($styles, $tab);
echo debut_html('edt', $choix);
echo "<body><h1>edt<\h1>";
echo choisir_style($styles, $media, $tab);
include '../../TD/8/edt.html';
/// Une ligne pour le TME 10
echo "<script type='text/javascript' src='choisirStyle.js'><\script>";
echo "<\body><\html>\n";