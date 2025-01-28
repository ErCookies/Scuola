//Cucchi Francesco 4BI boh.js
const descr = ["La Gioconda, conosciuta anche come Mona Lisa, è uno dei dipinti più celebri al mondo, realizzato da Leonardo da Vinci tra il 1503 e il 1506.",
"La Notte Stellata di Vincent van Gogh è uno dei dipinti più iconici dell'artista, realizzato nel 1889 mentre si trovava nel manicomio di Saint-Rémy-de-Provence.",
"L'orologio molle, noto anche come - La persistenza della memoria -, è uno dei dipinti più iconici di Salvador Dalí, realizzato nel 1931."];
const carat = ["<ul><li>Tecnica: Olio su tavola di legno.</li><li>Dimensioni: Circa 77 cm x 53 cm.</li><li>Soggetto: Ritratto di Lisa Gherardini, moglie di un mercante fiorentino.</li><li>Espressione: La sua espressione enigmatica e il famoso sorriso hanno affascinato critici e ammiratori per secoli.</li><li>Sfondo: Un paesaggio sfumato e mistico che sembra sfumare nel mistero, con colline e un fiume.</li></ul>",
"<ul><li>Colore e Movimento: Il dipinto è caratterizzato da vibranti tonalità di blu e giallo, con un cielo che sembra danzare grazie a pennellate dinamiche e fluide.</li><li>Elementi Naturali: La composizione include un grande cipresso in primo piano, simbolo di morte e vita, e un villaggio tranquillo sotto un cielo tumultuoso.</li><li>Atmosfera Emotiva: La rappresentazione del cielo notturno evoca sentimenti di speranza e melanconia, riflettendo il tumulto interiore di van Gogh.</li><li>Stile Post-Impressionista: La tecnica di pittura di van Gogh si distacca dal realismo, cercando di esprimere le sue emozioni attraverso il colore e la forma.</li></ul>",
"<ul><li>Tema principale: Rappresenta il concetto di tempo e la sua malleabilità.</li><li>Orologi deformati: Gli orologi appaiono morbidi e sciolti, appesi a rami di alberi e su una superficie.</li><li>Paesaggio: Lo sfondo è un paesaggio desolato, con un lago e montagne, che crea un'atmosfera surreale.</li><li>Simbolismo: Gli orologi che si deformano simboleggiano la relatività del tempo e la fragilità della realtà.</li><li>Colore: Utilizza una palette di colori tenui, con tonalità di blu e giallo, conferendo un senso di calma e inquietudine.</li></ul>"];

/*
	Utilizzando un array per contenere le descrizioni ed un altro per contenere
	le caratteristiche, creo una procedura che, dato il numero passato come parametro, 
	imposta un valore al paragrafo nell'HTML. Il numero rappresenta l'indice dell'array.
*/

function setDescriz(imgNum){
	const out = document.getElementById("txt");
	out.innerHTML = descr.at(imgNum);
}

function setCarat(imgNum){
	const out = document.getElementById("txt");
	out.innerHTML = carat.at(imgNum);
}
