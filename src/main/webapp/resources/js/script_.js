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
      $('form').html('');
      console.log(data);
      var h1 = $("<h1 class='question' id="+data.question.id+">");
      h1.text(data.question.title);
      $('form').append(h1);
        for(var i = 0; i < data.answers.length; i++) {
            $('form').append("<input class='answer' type='radio' name='answered' value="+data.answers[i].answerId+">"+data.answers[i].title+"</input>");
            $('form').append('<br>');
        }
        var button = $('<button>').html('Next').click(submitAnswer1);
        var finishButton = $('<button>').html('Finish').click(submitAnswer1);
        if(data.finished) {
            $('form').append(finishButton);
        } else {
            $('form').append(button);
        }
    }

})