
document.addEventListener("DOMContentReady" , () => {

});
function getProducts() {
    return fetch("/api/products")
    .then((response) => response.json())
    .catch((error) => console.log(error))
}

function toProductHtmlTemplate(product) {
    return `
        <li>
            <h2>${product.title}</h2>
            <span>${product.description}</span>
            <img src="${product.cover}"/>
            <span>${product.price}></span>
            <button data-product-id="${product.id}">Add basket</button>
        </li>
    `;
}

function toHtmlElement(templateStr) {
    htmlElement = document.createElement('<div>');
    htmlElement.innerHTML = templateStr;

    return htmlElement.firstChild();
}

function initializeAddToBasket(htmlElement) {
    htmlElement.querySelector('button').addEventListener('click', (e) => {
        const productId = e.target.getAttribute('data-product-id');
        console.log(`i am going to add product with id ${product.id}`);
    });

    return htmlElement;
}


(() => {
    const productsListElement = document.querySelector('.products-list');

    getProducts().then((products) => {
        products
            .map(toProductHtmlTemplate)
            .map(toElement)
            .map(initializeAddToBasket)
            .forEach((element) => {
                productsListElement.appendChild(element);
            });
    });
})();
    console.log("Hello world!")
