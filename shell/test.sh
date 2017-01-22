i=0
while read line
do
    if [ $i -eq 9 ]; then
	echo $line
    fi
let i++
done<file.txt
