function btnCalcOnClick(){

	const txtNum1 = document.getElementById("num1");
	const txtOp = document.getElementById("oper");
	const txtNum2 = document.getElementById("num2");
	const out = document.getElementById("output");

	let num1, num2;
	let op = txtOp.value;
	
	if(!isNaN(txtNum1.value) || txtNum1.value == "0"){
		num1 = parseInt(txtNum1.value);
		if(!isNaN(txtNum2.value) || txtNum2.value == "0"){
			num2 = parseInt(txtNum2.value);
			
			switch(op){
				case '+':{
					out.innerHTML += num1 + " + " + num2 + " = " + (num1 + num2) + "<br>";
					break;
				}
				case '-':{
					out.innerHTML += num1 + " - " + num2 + " = " + (num1 - num2) + "<br>";
					break;
				}
				case '*':{
					out.innerHTML += num1 + " * " + num2 + " = " + (num1 * num2) + "<br>";
					break;
				}
				case '/':{
					if(num2 != 0)
						out.innerHTML += num1 + " / " + num2 + " = " + (num1 / num2) + "<br>";
					else
						alert("Impossibile dividere per 0");
					break;
				}
				case '^':{
					out.innerHTML += num1 + " ^ " + num2 + " = " + (num1 ** num2) + "<br>";
					break;
				}
				case "rad":{
					out.innerHTML += "<sup>" + num2 + "</sup>" + "&Sqrt; " + num1 + " = " + (Math.pow(num1, (1 / num2)))+ "<br>";
					break;
				}
				default:{
					alert("Operazione non valida");
					break;
				}
			}
		}
		else
			alert("Secondo numero non valido");
	}
	else
		alert("Primo numero non valido");
	
}

function checkSelections(){
	const txtNum1 = document.getElementById("num1");
	const txtOp = document.getElementById("oper");
	const txtNum2 = document.getElementById("num2");
	const out = document.getElementById("output");
	
	if((!isNaN(txtNum1.value) || txtNum1.value == "0") && (!isNaN(txtNum2.value) || txtNum2.value == "0") && txtOp.value != "---")
		//
}