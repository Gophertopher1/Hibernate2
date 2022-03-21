function addProject() {
    //create individual forms for individual rows.
    let formLength = document.forms.length;

    //create the form
    let formCreated = document.createElement("form");
    formCreated.setAttribute("action", "project.html");
    formCreated.setAttribute("method", "post");
    formCreated.setAttribute("id", `form${formLength+1}`);
    //append to html body
    document.body.append(formCreated);

    //create new table row
    let tableRow = document.createElement("tr");
    tableRow.className="scriptAddedRow";

    //for name = code
    let tableData1 = document.createElement("td");
    let input1 = document.createElement("input");
    input1.type="text";
    input1.name="code";
    input1.className="scriptAdded";
    input1.setAttribute("form",`form${formLength+1}`);
    tableData1.append(input1);
    //add the table data with the inputs to the table row
    tableRow.append(tableData1);

    //for name = name
    let tableData2 = document.createElement("td");
    let input2 = document.createElement("input");
    input2.type="text";
    input2.name="name";
    input2.className="scriptAdded";
    input2.setAttribute("form",`form${formLength+1}`);
    tableData2.append(input2);
    //add the table data with the inputs to the table row
    tableRow.append(tableData2);

    //for name = date
    let tableData3 = document.createElement("td");
    let input3 = document.createElement("input");
    input3.type="date";
    input3.name="date";
    input3.className="scriptAdded";
    input3.setAttribute("form",`form${formLength+1}`);
    tableData3.append(input3);
    //add the table data with the inputs to the table row
    tableRow.append(tableData3);

    //for name = points
    let tableData4 = document.createElement("td");
    let input4 = document.createElement("input");
    input4.type="text";
    input4.name="points";
    input4.setAttribute("form",`form${formLength+1}`);
    input4.className="scriptAdded";
    tableData4.append(input4);
    //add the table data with the inputs to the table row
    tableRow.append(tableData4);

    //for name = isCompleted
    let tableData5 = document.createElement("td");
    let input5 = document.createElement("input");
    input5.type="text";
    input5.name="isCompleted";
    input5.className="scriptAdded";
    input5.setAttribute("form",`form${formLength+1}`);
    tableData5.append(input5);
    //add the table data with the inputs to the table row
    tableRow.append(tableData5);

    //for type = submit
    let tableData6 = document.createElement("td");
    let input6 = document.createElement("input");
    input6.type="submit";
    input6.value="Add to Database";
    input6.className = "submitBtn-login scriptAdded";
    input6.setAttribute("form",`form${formLength+1}`);
    tableData6.append(input6);
    //add the table data with the inputs to the table row
    tableRow.append(tableData6);


    //add the row to the table body
    document.getElementById("tableBody").append(tableRow);

    /*
        console.log(tableData1, tableRow);
        console.log(tableData2);
        console.log(tableData3);
        console.log(tableData4);
        console.log(tableData5);
        console.log(tableData6);*/

}


function removeProject() {
    //alert("We are removing project");

    let tableRows = document.getElementsByClassName("scriptAddedRow").length;
    if (tableRows == 0) {
        //this makes sure that the table rows are zero
        alert("All Table Rows have been deleted.");
    }
    else {
        //get the user's response
        let response = confirm("This will delete the last Table Row. \nAre you sure?");
        //we use tableRows - 1 because we always want to delete the last one each time
        //the button is clicked

        if (response==true) {
            //if the user clicks ok, then go ahead and delete.
            document.getElementsByClassName("scriptAddedRow")[tableRows - 1].remove();
        }

    }


}