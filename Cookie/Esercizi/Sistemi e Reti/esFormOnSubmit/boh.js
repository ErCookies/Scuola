function test(){
	const f = document.getElementById("formettino");
	const name = f.elements.name.value;
	const sur = f.elements.sur.value;
	const age = f.elements.age.value;
	const gender = f.elements.gender.value;
	const color = f.elements.color.value;
	let consent;
	if(f.elements.consent.value == "on")
		consent = true;
	else
		consent = false;
	//
	//alert(name);
	if(name == "" || sur == "" || !parseInt(age) || gender == "" || color == "---" || !consent)
		alert("almeno un valore errato");
	else
		alert("| " + name + " | " + sur + " | " + age + " | " + gender + " | " + color + " | " + consent + " |");
}