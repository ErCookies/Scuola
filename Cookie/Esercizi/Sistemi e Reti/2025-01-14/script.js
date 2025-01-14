let k = 0;
function fwd(){
	const im = document.getElementById("imgg");
	k++;
	if(k == 4){
		alert("Impossibile andare piu' avanti");
		k--;
	}
	im.src = "./img" + k + ".jpg";
}
function bck(){
	const im = document.getElementById("imgg");
	k--;
	if(k == -1){
		alert("Impossibile andare piu' indietro");
		k++;
	}
	im.src = "./img" + k + ".jpg";
}