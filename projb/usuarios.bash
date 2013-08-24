#! /bin/bash


#cualquier linea que no inicie con #, $1 usuario , $2 password
usuarios=$(awk ' BEGIN { FS = "=" };{if ( $0 !~ /^#/ ) printf "\n%s",$1 }' /usr/share/jboss/domain/configuration/mgmt-users.properties) #sera una variable
echo "Usuarios"
echo -e ${usuarios}


