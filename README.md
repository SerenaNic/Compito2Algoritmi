# Compito2Algoritmi

In un museo vi sono n sale. Ogni sala è individuata da un codice numerico e ha associate alcune informazioni, quali: l’elenco delle opere esposte, l’elenco degli impiegati e la possibile presenza dell’audio-guida in quella sala. Ogni opera è individuata, a sua volta, da un codice numerico ed è caratterizzata dal nome dell’autore, da una descrizione testuale, un’età stimata, un intero rappresentante il valore artistico dell’opera e dalla possibilità di essere in prestito.  Ogni impiegato è, invece, identificato da un codice numerico è ha associate alcune informazioni, quali: nome, genere (M/F), età e abilità lavorativa espressa tramite un intero. Due sale possono essere messe in comunicazione da un corridoio (entrambi i versi di percorrenza sono ammissibili). Ciascun corridoio è caratterizzato da un costo di manutenzione. 
Si rappresenti la situazione sopra descritta e si implementino le seguenti funzioni (il candidato non si deve occupare della inizializzazione del sistema, ma può ipotizzare un funzionamento a regime):

1.	metodo m1 che riceve due sale s1 e s2 ed un intero c. La funzione inserisce nel sistema l’informazione che le due sale sono collegate mediante un corridoio di costo c a patto che fra s1 e s2 non esista già un corridoio. 

2.	metodo m2 che accetta in ingresso due interi k e v. La funzione restituisce la lista delle sale comunicanti anche non direttamente con almeno altre 6 sale in cui (1) siano presenti non più di k opere il cui valore artistico è maggiore di v, (2) il numero di impiegati di genere femminile che lavorano nella sala abbia un’età inferiore a 30 anni.

3.	metodo m3 che accetta in ingresso una lista di sale saleList. Il museo deve essere ristrutturato, perciò dovranno essere eliminate tutte le sale presenti nella lista saleList. La funzione restituisce, se esiste, l’elenco dei corridoi che non bisogna eliminare per garantire che tutte le sale restanti siano raggiungibili da ogni altra sala e tale da assicurare un costo minimo di manutenzione totale.

4.	metodo m4 che riceve due sale s1 e s2. La funzione deve restituire il minimo numero di corridoi che è necessario attraversare per andare dalla sala s1 alla sala s2, senza passare per sale in cui non è presente l’audioguida.

Valutare la complessità delle funzioni proposte.


