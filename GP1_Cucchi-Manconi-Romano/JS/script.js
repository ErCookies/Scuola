// GP1 CUCCHI MANCONI ROMANO 4BI script.js

function formOnSubmit(form){
	let val = false;
    const name = form.elements.name,
        sur = form.elements.sur,
        mail = form.elements.mail,
        oggetto = form.elements.oggetto,
        mex = form.elements.mex;

    if(name.value != null && name.value != ""){
		if(sur.value != null && sur.value != ""){
			if(mail.value != null && mail.value != ""){
				if(oggetto.value != "---"){
					if(mex.value != null && mex.value != ""){
						alert(name.value + " | " + sur.value + " | " + mail.value + " | " + oggetto.value + " | " + mex.value);
						val = true;
					}
					else{
						alert("Inserire un messaggio");
						mex.focus();
					}
				}
				else{
					alert("Selezionare l'oggetto del reclamo");
					oggetto.focus();
				}
			}
			else{
				alert("Inserire la mail");
				mail.focus();
			}
		}
		else{
			alert("Inserire il cognome");
			sur.focus();
		}
	}
	else{
		alert("Inserire il nome");
		name.focus();
	}
	return val;
}