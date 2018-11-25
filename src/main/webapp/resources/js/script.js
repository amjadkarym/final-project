$(function(){
    $('#nextId').click(submitAnswer);
    function submitAnswer(e){
        e.preventDefault();
        var questionId = $('.question').attr('id');
        var answered = $("input[name='answered']:checked"). val();
        var data1 = {quesId:questionId, ansId:answered};
        $.ajax({
            url: '/quiz',
            type: 'get',
            dataType: 'json',
            data: {
                data: JSON.stringify(data1),
            },
            success: processData
        });

    };

    $('.nextCls').click(submitAnswer1);
    function submitAnswer1(){
        event.preventDefault();
        var questionId = $('.question').attr('id');
        var answered = $("input[name='answered']:checked"). val();
        var data1 = {quesId:questionId, ansId:answered};
        $.ajax({
            url: '/quiz',
            type: 'get',
            dataType: 'json',
            data: {
                data: JSON.stringify(data1),
            },
            success: processData
        });

    };

    function processData(data){
       // event.preventDefault();
        /*
      $('form').html('');
      console.log(data);
      var h1 = $("<h1 class='question' id="+data.question.id+">");
      h1.text(data.question.title);
      $('form').append(h1);
        for(var i = 0; i < data.answers.length; i++) {
            $('form').append("<input class='answer' type='radio' name='answered' value="+data.answers[i].answerId+">"+data.answers[i].title+"</input>");
            $('form').append('<br>');
        }
        var button = $('<button>').html("Next").click(submitAnswer1);
        $('form').append(button);
*/
        console.log(data);
        $('#quizDiv').html('');
        var h1 = $("<h4 class='mb-3 question' id="+data.question.id+">");
        h1.text(data.question.title);
        $('#quizDiv').append(h1);
        $('#quizDiv').append("<form class='needs-validation'><div class='col-md-6 mb-3 answers'>")
        for(var i = 0; i < data.answers.length; i++) {
            $('.answers').append("<div class='custom-control custom-radio'><input id="+data.answers[i].answerId+" name='answered' type='radio' class='custom-control-input answer' value="+data.answers[i].answerId+"><label class='custom-control-label' for="+data.answers[i].answerId+">"+data.answers[i].title+"</label></div>");
            //  $('.answers').append('<br>');
        }
        var button = $('<input class="btn btn-primary btn-lg btn-block" type="button" id="nextId" value="Next"/>').click(submitAnswer1);
        $('#quizDiv').append("<div class='row'> <div class='col-md-3 mb-3'><hr class='mb-4'></div></div>");
        $('#quizDiv .col-md-3.mb-3').append(button);
        $('.correctScoreId').text(data.correctAns);
        $('.wrongScoreId').text(data.wrongAns);
        var total = parseInt(data.correctAns) + parseInt(data.wrongAns);
        $('.resultScore').text(data.correctAns + "/" + total);

    }



})