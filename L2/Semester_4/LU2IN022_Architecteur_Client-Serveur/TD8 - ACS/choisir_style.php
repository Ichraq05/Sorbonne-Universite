<?php
include '../../TM/3/tableau_en_select.php';
include '../2/tableau_en_liste.php';
include '../3/html_form.php';
    
function choisir_style ($files, $media, $courants)
{
    $body = '';
    $files = array($files);
    foreach($media as $medium) {
        $body .= tableau_en_select($files, $medium, $courants[$medium]);
    }
    return html_form($body . "<input type='submit' />", 'post');
}
?>
