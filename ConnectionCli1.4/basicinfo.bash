#Despliega el xml de informacion basica de Jboss eap 6.1
#! /bin/bash
#version 1.0.0
#ejecutar como root


#Algunas otr

jdkruta=$(whereis java)

#Global Variable
#asignamos direccion del archivo
touch /tmp/Chapter.xml
Chap=/tmp/Chapter.xml


#header xml
echo "<?xml version='1.0' encoding='utf-8' ?>"> $Chap
echo '<!DOCTYPE chapter PUBLIC "-//OASIS//DTD DocBook XML V4.5//EN" "http://www.oasis-open.org/docbook/xml/4.5/docbookx.dtd" [' >> $Chap
echo '<!ENTITY % BOOK_ENTITIES SYSTEM "redhat-Consulting.ent">' >> $Chap
echo '%BOOK_ENTITIES;' >> $Chap
echo ']>' >> $Chap

#inicio y nombre del capitulo
echo '<chapter id="chap-redhat-JBoss">' >> $Chap
# Title are created as needed
echo -e '\t<title>Datos Generales</title>' >> $Chap
echo -e '\t\t<section id = "Jboss informacion basica"> </section>\n'>> $Chap
echo -e '\t\t\t<para>'>> $Chap

#especificamos la ruta de los usuarios
dirusers=$(find / -path '*domain/configuration/*' -name mgmt-users.properties) #$jbossruta$usuraiosruta

#extrae los usuarios jboss
usuarios=$(awk ' BEGIN { FS = "=" };{if ( $0 !~ /^#/ ) printf "\\n<usuario>%s<usuario/>",$1 }' $dirusers) #sera una variable
echo $jdkruta>> $Chap
echo "Ruta Jboss">> $Chap
echo $dirusers>> $Chap
#echo "Usuarios"
echo -e ${usuarios}>> $Chap
echo -e '\t\t\t</para>'>> $Chap
echo -e '\t\t</section>'>> $Chap
#END SECTION

#####END CHAPTER
echo '</chapter>' >> $Chap
