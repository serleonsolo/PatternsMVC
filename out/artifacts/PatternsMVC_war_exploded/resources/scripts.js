function loadContent(root, suffix, currentPage) {

    let objects = JSON.parse(Get(root + "/rest/patterns" + suffix).responseText);
    let patternsCount = Get(root + "/rest/patterns/count" + suffix).responseText;
    document.getElementById("count").innerText = "Patterns found: " + patternsCount;
    let table = document.getElementById("mainTable");
    table.innerHTML = "";
    createPaging(document.getElementById("limit").value, patternsCount, currentPage);

    for (let i = 0; i < objects.length; i++) {

        let tr = document.createElement("tr");
        let th = document.createElement("th");
        th.setAttribute("scope", "row");
        th.appendChild(document.createTextNode(objects[i].id));
        tr.appendChild(th);
        let td1 = document.createElement("td");
        td1.appendChild(document.createTextNode(objects[i].name));
        tr.appendChild(td1);
        let td2 = document.createElement("td");
        td2.appendChild(document.createTextNode(objects[i].description));
        tr.appendChild(td2);
        let td3 = document.createElement("td");
        let patternType = objects[i].patternType.charAt(0).toUpperCase() + objects[i].patternType.slice(1).toLowerCase();
        td3.appendChild(document.createTextNode(patternType));
        tr.appendChild(td3);
        let isMain;
        if (objects[i].isMain) {
            isMain = "Main";
        } else {
            isMain = "Additional";
        }
        let td5 = document.createElement("td");
        td5.appendChild(document.createTextNode(isMain));
        tr.appendChild(td5);
        let td8 = document.createElement("td");
        td8.appendChild(document.createTextNode(objects[i].rating));
        tr.appendChild(td8);
        let warButton = document.createElement("button");
        warButton.setAttribute("type", "button");
        warButton.setAttribute("class", "btn btn-warning btn-sm");
        warButton.appendChild(document.createTextNode("Edit"));
        warButton.addEventListener("click", function () {
            editButtonClick(root, tr, objects[i].id)
        });
        let td9 = document.createElement("td");
        td9.appendChild(warButton);
        tr.appendChild(td9);
        let dangerButton = document.createElement("button");
        dangerButton.setAttribute("type", "button");
        dangerButton.setAttribute("class", "btn btn-danger btn-sm");
        dangerButton.appendChild(document.createTextNode("Delete"));
        dangerButton.addEventListener("click", function () {
            processDelete(root, objects[i].id)
        });
        let td10 = document.createElement("td");
        td10.appendChild(dangerButton);
        tr.appendChild(td10);
        let showButton = document.createElement("button");
        showButton.setAttribute("type", "button");
        showButton.setAttribute("class", "btn-outline-info btn-sm");
        showButton.appendChild(document.createTextNode("Show"));
        showButton.addEventListener("click", function () {
            processShow(root, objects[i].id)
        });
        let td11 = document.createElement("td");
        td11.appendChild(showButton);
        tr.appendChild(td11);
        table.appendChild(tr);
    }
    window.scrollTo(500, 100);
}

function Get(requestUrl) {
    let Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("GET", requestUrl, false);
    Httpreq.send(null);
    if (Httpreq.status === 400) {
        $('#error-text').text("Bad request to GET " + requestUrl);
        $('#myModal').modal('show');
    }
    if (Httpreq.status === 404) {
        $('#error-text').text("Not found GET " + requestUrl);
        $('#myModal').modal('show');
    }
    return Httpreq;
}

function post(requestUrl, body) {
    let Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("POST", requestUrl, false);
    Httpreq.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    Httpreq.send(body);
    if (Httpreq.status === 400) {
        $('#error-text').text("Bad request to POST " + requestUrl);
        $('#myModal').modal('show');
    }
    if (Httpreq.status === 404) {
        $('#error-text').text("Not found POST " + requestUrl);
        $('#myModal').modal('show');
    }
    return Httpreq;
}

function Delete(requestUrl) {
    let Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("DELETE", requestUrl, false);
    Httpreq.send(null);
    console.log(Httpreq.status);
    if (Httpreq.status === 400) {
        $('#error-text').text("Bad request to DELETE " + requestUrl);
        $('#myModal').modal('show');
    }
    if (Httpreq.status === 404) {
        $('#error-text').text("Not found DELETE " + requestUrl);
        $('#myModal').modal('show');
    }
    return Httpreq;
}

function processSearch(root, currentPage) {
    let name = document.getElementById("inputName").value;
    let description = document.getElementById("inputDescription").value;
    let ratingMin = document.getElementById("inputRatingMin").value;
    let ratingMax = document.getElementById("inputRatingMax").value;
    let patternType = document.getElementById("inputPatternType").value;
    let order = document.getElementById("order").value;
    let isMain = null;
    let limit = document.getElementById("limit").value;
    if (document.getElementById("inlineRadio2").checked) {
        isMain = true;
    } else if (document.getElementById("inlineRadio3").checked) {
        isMain = false;
    }
    let sufix = "?";
    if (name !== "") {
        sufix += "name=" + name;
    }
    if (description !== "") {
        sufix += "&description=" + description;
    }
    if (patternType !== "Any") {
        sufix += "&patternType=" + patternType.toUpperCase();
    }
    if (isMain !== null) {
        sufix += "&isMain=" + isMain;
    }
    if (ratingMin !== "") {
        sufix += "&minRating=" + ratingMin;
    }
    if (ratingMax !== "") {
        sufix += "&maxRating=" + ratingMax;
    }

    sufix += "&pageNumber=" + (+currentPage - 1);
    sufix += "&pageSize=" + +limit;

    console.log(limit);

    if (order === "Pattern Type") {
        order = "type";
    }

    sufix += "&order=" + order.toUpperCase();
    loadContent(root, sufix, currentPage);
}

function createPaging(patternsInPage, patternsSummary, currentPage) {
    let paggingBar = document.getElementById("pagging-bar");
    paggingBar.innerHTML = "";
    let pagesCount = patternsSummary / patternsInPage;
    if (pagesCount > 1) {

        for (let i = 0; i < pagesCount; i++) {
            let li = document.createElement("li");
            if (i === currentPage - 1) {
                li.setAttribute("class", "page-item disabled");
            } else {
                li.setAttribute("class", "page-item");
            }
            let a = document.createElement("a");
            a.setAttribute("class", "page-link");
            a.setAttribute("href", "#");
            let root = document.getElementById("root").getAttribute("about");
            a.setAttribute("onclick", "processSearch('" + root + "', " + (i + 1) + ")");
            a.appendChild(document.createTextNode(i + 1));
            li.appendChild(a);
            paggingBar.appendChild(li);
        }
    }
}

function editButtonClick(root, element, id) {
    let objectToUpdate = JSON.parse(Get(root + "/rest/patterns/" + id).responseText);
    if (document.body.contains(document.getElementById("update" + id))) {
        document.getElementById("update" + id).remove();
        return;
    }
    let tr = document.createElement("tr");
    tr.setAttribute("id", "update" + objectToUpdate.id);

    let th = document.createElement("th");
    th.setAttribute("scope", "row");
    th.appendChild(document.createTextNode(""));
    tr.appendChild(th);

    let td1 = document.createElement("td");
    let nameInput = document.createElement("input");
    nameInput.setAttribute("type", "text");
    nameInput.setAttribute("class", "form-control");
    nameInput.setAttribute("size", "10");
    nameInput.setAttribute("style", "font-family:monospace");
    nameInput.setAttribute("id", "updateName" + objectToUpdate.id);
    nameInput.setAttribute("value", objectToUpdate.name);
    td1.appendChild(nameInput);
    tr.appendChild(td1);

    let td2 = document.createElement("td");
    let descriptionInput = document.createElement("input");
    descriptionInput.setAttribute("type", "text");
    descriptionInput.setAttribute("class", "form-control input-sm");
    descriptionInput.setAttribute("size", "6");
    descriptionInput.setAttribute("style", "font-family:monospace");
    descriptionInput.setAttribute("id", "updateDescription" + objectToUpdate.id);
    descriptionInput.setAttribute("value", objectToUpdate.description);
    td2.appendChild(descriptionInput);
    tr.appendChild(td2);

    let td3 = document.createElement("td");
    let patternTypeInput = document.createElement("select");
    patternTypeInput.setAttribute("class", "form-control input-sm");
    patternTypeInput.setAttribute("id", "updatePatternType" + objectToUpdate.id);
    patternTypeInput.setAttribute("style", "font-family:monospace");
    let patternType = ["Creational", "Structural", "Behavioral"];
    for (let i = 0; i < patternType.length; i++) {
        let option = document.createElement("option");
        if (patternType[i].toUpperCase() === objectToUpdate.patternType.toUpperCase()) {
            option.selected = true;
        }
        option.appendChild(document.createTextNode(patternType[i]));
        patternTypeInput.appendChild(option);
    }
    td3.appendChild(patternTypeInput);
    tr.appendChild(td3);

    let td5 = document.createElement("td");
    let isMainInput = document.createElement("select");
    isMainInput.setAttribute("class", "form-control input-sm");
    isMainInput.setAttribute("style", "font-family:monospace");
    isMainInput.setAttribute("id", "updateIsMain" + objectToUpdate.id);
    let isMainType = ["Main", "Additional"];
    for (let i = 0; i < isMainType.length; i++) {
        let option = document.createElement("option");
        if (objectToUpdate.isMain === true && isMainType[i] === "Main") {
            option.selected = true;
        }
        if (objectToUpdate.isMain === false && isMainType[i] === "Additional") {
            option.selected = true;
        }
        option.appendChild(document.createTextNode(isMainType[i]));
        isMainInput.appendChild(option);
    }
    td5.appendChild(isMainInput);
    tr.appendChild(td5);

    let td8 = document.createElement("td");
    td8.appendChild(document.createTextNode(objectToUpdate.rating));
    tr.appendChild(td8);

    let td9 = document.createElement("td");
    td8.appendChild(document.createTextNode(""));
    tr.appendChild(td9);

    let td10 = document.createElement("td");
    let saveButton = document.createElement("button");
    saveButton.setAttribute("type", "button");
    saveButton.setAttribute("class", "btn btn-success btn-sm");
    saveButton.addEventListener("click", function () {
        sendUpdate(root, objectToUpdate.id)
    });
    saveButton.appendChild(document.createTextNode("Save"));
    td10.appendChild(saveButton);
    tr.appendChild(td10);

    element.insertAdjacentElement("afterEnd", tr);
}

function sendUpdate(root, id) {
    let body = {};
    body.name = document.getElementById("updateName" + id).value;
    body.description = document.getElementById("updateDescription" + id).value;
    body.patternType = document.getElementById("updatePatternType" + id).value.toUpperCase();
    let isMain = document.getElementById("updateIsMain" + id).value;
    body.isMain = isMain === "main";

    post(root + "rest/patterns/" + id, JSON.stringify(body));
    loadContent(root, "", 1);
}

function clickCreate() {
    let elem = document.getElementById("createButton");
    if (elem.style.display === "none") {
        elem.style.display = "block";
    } else {
        elem.style.display = "none"
    }
}

function processCreate(root) {
    let body = {};
    body.name = document.getElementById("inputNameNew").value;
    body.description = document.getElementById("inputDescriptionNew").value;
    body.patternType = document.getElementById("inputPatternTypeNew").value.toUpperCase();
    if (document.getElementById("inlineRadioNew1").checked) {
        body.isMain = true;
    } else if (document.getElementById("inlineRadioNew2").checked) {
        body.isMain = false;
    }
    let response = post(root + "rest/patterns/", JSON.stringify(body));
    if (response.status === 200) {
        document.getElementById("inputNameNew").value = "";
        document.getElementById("inputDescriptionNew").value = "";
        document.getElementById("inputPatternTypeNew").value = "Creational";
        if (document.getElementById("inlineRadioNew2").checked) {
            document.getElementById("inlineRadioNew2").checked = false;
            document.getElementById("inlineRadioNew1").checked = true;
        }
    }

    processSearch(root, 1);
}

function processDelete(root, id) {
    Delete(root + "rest/patterns/" + id);
    processSearch(root, 1);
}

function processShow(root, id) {
    let body = {};
    let response = Get(root + "rest/patterns/show/" + id);
    if (response.status === 200) {
        $('#info-text').text("Process results: " + response.responseText);
        $('#showModal').modal('show');
    }
    processSearch(root, 1);
}