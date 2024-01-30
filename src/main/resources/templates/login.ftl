<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2 class="text-center"> Auth </h2>

    <form action="/login" method="post">

        <label for="username">Username</label><br>
        <input type="text" name="username" id="username" placeholder="user"><br>

        <label for="password">Password</label><br>
        <input type="password" name="password" id="password" placeholder="user"><br>

        <button class="btn btn-success" type="submit">Add</button>
    </form>

    <a href="/registration"> Перехід на сторінку реєстрації</a>

</@p.pages>

