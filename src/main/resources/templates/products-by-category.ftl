<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2> Products by Category </h2>

    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if productsByCategory??>
            <#list productsByCategory as product>
                <div class="col">
                    <div class="card">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                        <div class="card-body text-center">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text"> ${product.description} </p>
                            <p> Price: ${product.price}</p>
                            <p> Ont: 1</p>
                            <p> ${product.categories.name} </p>
                        </div>
                        <button type="submit">AddToCard</button>
                    </div>
                </div>
            </#list>
        </#if>
    </div>





</@p.pages>