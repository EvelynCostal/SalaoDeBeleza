const form = document.getElementById('formAgendamento');
const mensagem = document.getElementById('mensagem');
const menuToggle = document.querySelector('.menu-toggle');
const navMenu = document.querySelector('nav ul');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const dados = {
        nome: document.getElementById('nome').value,
        servico: document.getElementById('servico').value,
        data: document.getElementById('data').value,
        hora: document.getElementById('hora').value + ":00"
    };

    try {
        const resposta = await fetch('/api/agendamentos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados)
        });

        const textoResposta = await resposta.text();

        if (resposta.ok) {
            mensagem.style.color = 'green';
            mensagem.textContent = textoResposta;
            form.reset();
        } else {
            mensagem.style.color = 'red';
            mensagem.textContent = textoResposta;
        }
    } catch (error) {
        mensagem.style.color = 'red';
        mensagem.textContent = 'Erro ao conectar com o servidor.';
        console.error('Erro:', error);
    }
});

if (menuToggle && navMenu) {
    menuToggle.addEventListener('click', () => {
        const aberto = navMenu.classList.toggle('aberto');
        menuToggle.classList.toggle('ativo', aberto);
        menuToggle.setAttribute('aria-expanded', aberto);
        menuToggle.setAttribute('aria-label', aberto ? 'Fechar menu' : 'Abrir menu');
    });

    navMenu.querySelectorAll('a').forEach((link) => {
        link.addEventListener('click', () => {
            navMenu.classList.remove('aberto');
            menuToggle.classList.remove('ativo');
            menuToggle.setAttribute('aria-expanded', 'false');
            menuToggle.setAttribute('aria-label', 'Abrir menu');
        });
    });
};