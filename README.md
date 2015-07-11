# p3-tutorial-sugarorm

### Tutorial criado para a disciplina Programação 3 (CIn-UFPE) sobre uso do SugarORM.

O SugarORM é uma API que busca simplificar a utilização de bancos SQLite no Android. Ele atinge seu objetivo por:
- Eliminar queries de SQL
- Criar o banco de dados
- Gerenciar os relacionamentos entre tabelas
- Providenciar uma API simples para operações CRUD
- Instalação requer uma configuração mínima
- Suporte para migrações

## Página Oficial

A documentação oficial do SugarORM pode ser obtido nos links:
- [SugarORM](http://satyan.github.io/sugar/index.html)
- [GitHub](https://github.com/satyan/sugar)

## Instalação

A instalação do SugarORM é bastante simples, e pode ser feita de diversas maneiras.

Após ter um projeto Android criado, basta escolher uma das formas abaixo:

#### Dependência do Gradle

Basta adicionar o código

```groovy
compile 'com.github.satyan:sugar:1.3.1'
```

ao arquivo build.gradle (app), na parte de dependencies, e executar o comando `gradle build` ou `gradle assemble`.

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%202.png "gradle dependency")
![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%203.png "execute gradle")
![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%204.png "execute gradle")

#### Dependendência do Maven

Declarar a dependência no arquivo do Maven

```xml
<dependency>
    <groupId>com.github.satyan</groupId>
    <artifactId>sugar</artifactId>
    <version>1.3</version>
</dependency>
```

#### Como uma lib do projeto

Fazer o download do [código-fonte](https://github.com/satyan/sugar/tree/master/library) e importar como uma lib do projeto no Eclipse. Para mais informações, ler [isto](http://developer.android.com/tools/projects/index.html#LibraryProjects).

#### Como um jar

Visite a página [releases](https://github.com/satyan/sugar/releases)  para realizar o download do ja. Depois, adicione-o na pasta `libs` de seu projeto.


## Configuração

Com a instalação finalizada, o projeto deve ser configurado para permitir sua utilização. 

No arquivo AndroidManifest.xml, adicione `android:name = "com.orm.SugarApp"` dentro da tag `application`. Em seguida, adicione os meta-datas abaixo.

```xml
<application android:label="@string/app_name" android:icon="@drawable/icon"
android:name="com.orm.SugarApp">
.
.
<meta-data android:name="DATABASE" android:value="sugar_example.db" />
<meta-data android:name="VERSION" android:value="2" />
<meta-data android:name="QUERY_LOG" android:value="true" />
<meta-data android:name="DOMAIN_PACKAGE_NAME" android:value="com.example" />
.
.
</application>
```
![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%205.png "config")

  
Após esse passo, o SugarOrm já está configurado e pronto para uso! 

## Utilização

Para utilizar o SugarORM nos models do projeto, basta extender `SugarRecord` nas classes que devem ser persistidas. Isso faz com que as tabelas sejam criadas automaticamente, além de dar todas as operações para gerenciamento da entidade.

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%206.png "config")

**É necessário que a classe sempre tenha algum de seus construtores vazios.**

## Operações

A realização das operações CRUD (Create, Read, Update e Delete) podem ser feitas através dos métodos `save()`,`findById(..)` e `delete()`. Além disso, operações em *bulk* podem ser utilizadas (ex.: `listAll(..)`, `deleteAll(..)`).

#### Exemplo de utilização do `listAll(..)`:

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%207.png "listAll")

#### Exemplo de utilização do `findById(..)`:

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%208.png "findbyid")

#### Exemplo de utilização do `save()`:

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%209.png "save")

#### Exemplo de utilização do `delete()`:

![Alt text](https://github.com/marcel-reboucas/p3-tutorial-sugarorm/blob/master/screenshots/passo%2010.png "delete")

###Isso é tudo! Comece já a usar o SugarORM :)



