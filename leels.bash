#! /bin/bash
rutaserver=$"/tmp/lsserver.out"
ls -1   > $rutaserver
ruta=$"/log/host.xml"
while read line
	do
	  echo $line$ruta
	done < $rutaserver

 
	
