

$(".carousel").slick({
    infinite: true,
    speed: 300,
    slidesToShow:4,
    slidesToScroll: 1,
    prevArrow: '<button type="button" class="slick-prev">❮</button>',
    nextArrow: '<button type="button" class="slick-next">❯</button>',
  
    responsive: [ 
  
      {
        breakpoint:768, settings: "unslick"
      },
  
  
    ]
  });
  
  /*   const slide = document.querySelector('.carousel-slide');
    const items = document.querySelectorAll('.carousel-item');
    const prevButton = document.querySelector('.prev-btn');
    const nextButton = document.querySelector('.next-btn');
    
    let counter = 0;
    const size = items[0].clientWidth;
    
    nextButton.addEventListener('click', () => {
        if (counter >= items.length - 1) return;
        slide.style.transform = `translateX(${-size * (counter + 1)}px)`;
        counter++;
    });
    
    prevButton.addEventListener('click', () => {
        if (counter <= 0) return;
        slide.style.transform = `translateX(${-size * (counter - 1)}px)`;
        counter--;
    });
     */