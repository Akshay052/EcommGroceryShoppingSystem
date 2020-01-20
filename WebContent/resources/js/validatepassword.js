
function validatepass()
{
	var nm1=document.getElementById("createpass").value;
	var nm2=document.getElementById("repeatpass").value;
    var myp=document.getElementById("msg");
	

      
		
		  if(nm1==nm2)
		{		  
			return true;
		}
		
		else{
			myp.innerHTML="password not matching";
			return false;
		}
		  
		
}
function validatephone()
{
	
	var phn=document.getElementById("phone").value;
    var myp2=document.getElementById("msg2");

      
		
		  if(phn.length==10)
		{		  
			return true;
		}
		
		else{
			myp.innerHTML="phone no should 10 numbers";
			return false;
		}
		  
		
}
