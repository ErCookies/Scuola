function lgInt(mex){
	let x;
	x = parseInt(prompt(mex));
	return x;
}

function contrPos(x){
	return x > 0;
}

function contrTriangolo(l1, l2, l3){
	return ((l1 == l2 && l2 == l3) || (l1 + l2 > l3 && l2 + l3 > l1 && l1 + l3 > l2));
}

