# mailsender

<hr>
Microserviço p/ envio de email Desenvolvido com Java/Spring.

Essa ferramenta funciona recebendo uma requisição POST no endpoint /send-email contendo os dados do email, que são:

- ownerRef - Referência do usuário na outra aplicação.
- emailFrom - email remetente
- emailTo - destinatário
- subject - assunto
- text - conteúdo
- sendDate - data de envio
- statusEmail - status do email
<hr>

#### Adicione as linhas a seguir no application.properties para configurar o email (Config base p/ GMAIL):
- spring.mail.host=smtp.gmail.com
- spring.mail.port=587
- spring.mail.username=SEU_EMAIL
- spring.mail.password=SUA_SENHA
- spring.mail.properties.mail.smtp.auth=true
- spring.mail.properties.mail.smtp.starttls.enable=true
