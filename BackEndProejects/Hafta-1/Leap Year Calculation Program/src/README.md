ARTIK YIL HESAPLAMA PROGRAMI / LEAP YEAR CALCULATION PROGRAM


Adımlar;

İhtiyaç duyulan değişkenler ve scanner tanımlanır.

Mantık; girilen tarihin 400 e tam bölünebilmesi veya 

girilen tarihin hem 4 e tam bölünüp hem de 100 e tam bölünememesi

yani ((a % 400 ==0) || ((a%100!=0) && (a%4==0)))

Örnek case:
400 e tam bölünebilenler (örnek 1600-2000-2400) VEYA
100 e bölümünden 0 kalmasın (örnek 1996-1997-1998-1999-2001-2002)  VE
4 e tam bolunebilenler gelsin (1000-1996-2000-2004-1300)
Açıklama: 
 VE mantıksal operatorlerinde belirtildiği gibi
hem 100 e bölümünden kalan 0 a eşit olmasın hem de 4 e tam bölünebilsin
bu durumda (1000-1300-1996-1997-1998-1999-2001-2000-2002-2004) kümesinden dışarıya 1996-2004 çıkar.
daha sonra VEYA operatöründe belirtildiği gibi
400 e bölünebiller veya 1996-2004 olsun. bu durumda dışarıya 1996,2000,2004 cıkar.