
# Some Example script to build bash scripting 
#!/bin/bash 
#Global Variable
touch	/tmp/Chapter.xml
Chap=/tmp/Chapter.xml 

echo "<?xml version='1.0' encoding='utf-8' ?>"> $Chap
echo '<!DOCTYPE chapter PUBLIC "-//OASIS//DTD DocBook XML V4.5//EN" "http://www.oasis-open.org/docbook/xml/4.5/docbookx.dtd" [' >> $Chap 
echo '<!ENTITY % BOOK_ENTITIES SYSTEM "redhat-Consulting.ent">' >> $Chap
echo '%BOOK_ENTITIES;' >> $Chap
echo ']>' >> $Chap 


#Build the chapter id 
echo '<chapter id="chap-redhat-Consulting-Datos_Generales">' >> $Chap 
# Title are created as needed 
echo -e '\t<title>Datos Generales del Sistema</title>' >> $Chap
	# tag <para> to paragraph </para> to Datos Generales del Sistema 
	echo -e '\t<para>' >> $Chap 
	echo -e '\t\tLa información es obtenida mediante comandos del sistema el día-mes-año, dicha información puede ser modificada con el paso del tiempo.' >> $Chap
	echo -e '\t</para>' >> $Chap
	# end tag to Datos Generales del Sistema
	
	
	# Define Hardware section and titles
echo -e '\t<section id="sect-redhat-Consulting-Datos_Generales-Información_Networking_1">' >> $Chap
echo -e '\t\t<title></title>' >> $Chap
	# tag <para> to paragraph </para> to Hardware title
	echo -e '\t\t<para>' >> $Chap
	echo -e '\t\t\t' >> $Chap 
	#Create list items <segmentedlist> 
	#Variables Hardware
	# finding Characteristics
	
	
	#ARCH=$(uname -p)
	#ARCHVEN=$(dmidecode -t 3 | grep Manufacturer: | awk '{print  $2, $3 }' )
	ARCHVEN1=$(dmidecode -t 3 | grep Type: | awk '{print  $2, $3 }' )
	#ARCHENV2=$(dmidecode -t 3 | grep "Serial Number:" | awk '{print  $2, $3 }' )
	#ARCHENV3=$(dmidecode -t 3 | grep "Asset Tag:" | awk '{print  $2, $3 }' )
        #ARCHFAM=$(dmidecode -t 4 | grep Family: | awk '{print $2, $3 }' )
        #ARCHMFR=$(dmidecode -t 4 | grep Manufacturer: | awk '{print  $2, $3 }' )

	
	


	#informacion 
	USERNAME=$(grep -A 1 -m 1 username  /etc/sysconfig/rhn/systemid | sed -r 's/<(\/{0,1}[a-z]{1,9})>//g'|tail -n 1 )
	CHECKSUM=$(grep -A 1 -m 1 checksum  /etc/sysconfig/rhn/systemid | sed -r 's/<(\/{0,1}[a-z]{1,9})>//g'|tail -n 1)
	PROFILE=$(grep -A 1 -m 1 profile_name /etc/sysconfig/rhn/systemid | sed -r 's/<(\/{0,1}[a-z]{1,9})>//g'|tail -n 1)
	IDSYSTEM=$(grep -A 1 -m 1 system_id /etc/sysconfig/rhn/systemid | sed -r 's/<(\/{0,1}[a-z]{1,9})>//g'|tail -n 1)
	LANGUAJE=$(locale |egrep LANG)
	GROUPINSTALL=$(rpm -qia | grep -E '^(Name|Group)( )+:'| grep -B 1  "Applications/Internet" | awk '{if($3 !="Applications/Internet" && $3 !="  "){print  $3 "    "}}')	
	




	# end finding
		echo -e '\t\t\t<segmentedlist> <title>Informacion </title>' >> $Chap
		
		echo -e '\t\t\t<?dbhtml list-presentation="list"?>' >> $Chap
			echo -e '\t\t\t\t<segtitle>UserName</segtitle>' >> $Chap
			echo -e '\t\t\t\t<segtitle>Checksum</segtitle>' >> $Chap
			echo -e '\t\t\t\t<segtitle>Nombre de Perfil</segtitle>' >>$Chap
			echo -e '\t\t\t\t<segtitle>ID de Sistema</segtitle>' >>$Chap
			echo -e '\t\t\t\t<segtitle>Lenguaje</segtitle>' >>$Chap
			echo -e '\t\t\t\t<segtitle>Aplicaciones de Internet</segtitle>' >>$Chap

		

			echo -e '\t\t\t\t<seglistitem>' >> $Chap
			echo -e "\t\t\t\t<seg>$USERNAME</seg>" >> $Chap
			echo -e "\t\t\t\t<seg>$CHECKSUM</seg>" >> $Chap 
			echo -e "\t\t\t\t<seg>$PROFILE</seg>" >> $Chap
			echo -e "\t\t\t\t<seg>$IDSYSTEM</seg>" >> $Chap
			echo -e "\t\t\t\t<seg>$LANGUAJE</seg>" >> $Chap
			echo -e "\t\t\t\t<seg>$GROUPINSTALL</seg>" >> $Chap




			echo -e '\t\t\t\t</seglistitem>' >> $Chap
		echo -e '\t\t\t</segmentedlist>' >> $Chap
	# end list items ,/segmentedlist> 
		echo -e '\t\t</para>' >> $Chap
		
		
	

	# end tag <para> to paragraph </para> to Hardware title
		echo -e '\t</section>\n' >> $Chap
	# end tag section to Hardware and create new section to Informaci[on del sistema
	
	
	
	
	
	
	echo '</chapter>' >> $Chap
