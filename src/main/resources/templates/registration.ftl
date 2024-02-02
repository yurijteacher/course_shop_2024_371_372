<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2> Registration </h2>
    <form action="/registration" method="post">

    <@spring.bind "users"/>
    <label> Username</label>
    <@spring.formInput "users.username"/><br>
    <@spring.showErrors "<br>"/><br>

    <label> Password</label>
    <@spring.formInput "users.password"/><br>
    <@spring.showErrors "<br>"/><br>

    <@spring.bind "clients"/>
    <label> firstname</label>
    <@spring.formInput "clients.firstName"/><br>
    <@spring.showErrors "<br>"/><br>

    <label> lastname</label>
    <@spring.formInput "clients.lastName"/><br>
    <@spring.showErrors "<br>"/><br>

    <label> age </label>
    <@spring.formInput "clients.age"/><br>
    <@spring.showErrors "<br>"/><br>

    <label> email </label>
    <@spring.formInput "clients.email"/><br>
    <@spring.showErrors "<br>"/><br>

    <label> phone </label>
    <@spring.formInput "clients.phone"/><br>
    <@spring.showErrors "<br>"/><br>


        <button type="submit">Add </button>

    </form>
</@p.pages>