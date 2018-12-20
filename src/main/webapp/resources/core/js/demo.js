//Ajax Function check whether Username is exists
function lookUpUserNameAvailable(userName) {
    $.ajax({
        url : contexPath + "/checkUserName.spr",
        data: "userName=" + userName.value,
        type: "post",
        success: function(response) {
            console.log("SUCCESS: ", response);
            $("#userNameLabelID").text(response);
        },
        error : function(e) {
            console.log("ERROR: ", e);

        },
        done : function(e) {
            console.log("DONE");
        }
    });
}
//Ajax Function Look UP CapitalRegion
function lookUpCapitalRegion(province) {
    $("#capitalRegionId").empty();
    $("#majorCitiesId").empty();
    $.ajax({
        url : contexPath + "/lookUpCapitalRegion.spr",
        data: "province=" + province.value,
        type: "post",
        success: function(data) {
            console.log("SUCCESS: ", data);
            var array = data.split(",");
            for(var i=0;i < array.length;i++){
                $('#capitalRegionId').append( '<option value="'+array[i].trim()+'">'+array[i].trim()+'</option>' );
            }
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}
//Ajax Function Look UP MajorPlaces
function lookUpMajorCities(capitalRegion) {
    $("#majorCitiesId").empty();
    $.ajax({
        url : contexPath + "/lookUpMajorCities.spr",
        data: "capitalRegion=" + capitalRegion.value,
        type: "post",

        success: function(data) {
            console.log("SUCCESS: ", data);
            var obj=JSON.parse(data);
            var responceString=obj.MajorCities.toString();
            var array=responceString.substring(1,responceString.length-1).split(",");
            for(var i=0;i < array.length;i++){
                $('#majorCitiesId').append( '<option value="'+array[i].trim()+'">'+array[i].trim()+'</option>' );
            }
            $('#populationId').val(obj.population);
            $('#areaId').val(obj.totalArea);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}
function refreshControl(){
    location.reload();
}

var user={
    name:"naveen",
    say:function (words){alert(words);}
}
function onclickFunction(){

}


