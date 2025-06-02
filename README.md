# Hyplus Project AI

[Hyperplasma](https://www.hyperplasma.top) [SpringAI大模型应用开发教程](https://www.hyperplasma.top/article/12880/) 

A glimpse into Spring AI

## 项目简介

Hyplus Project AI（HyProj-AI）是一个基于 Spring Boot 和 Spring AI 的大模型应用开发示例，支持多模态对话、会话历史管理、OpenAI 接入等功能，适合学习和二次开发。

## 主要特性

- 支持文本和多模态（文件/图片）对话
- 集成 OpenAI GPT-4o-mini 等模型
- 支持会话 ID 生成与历史保存
- 数据库选型灵活（采用 SQLite 作示例，详见 `db/db_init.md`）
- 响应式接口，基于 WebFlux
- 代码简洁，易于扩展

## 环境要求

- JDK 17 及以上
- Maven 3.9+
- 推荐使用 IntelliJ IDEA
- 网络可访问 OpenAI API

## 快速开始

1. **克隆项目**

```bash
git clone https://github.com/hyperplasma/hyproj-ai.git
cd hyproj-ai
```

2. **配置环境变量**
   - 在本地环境设置 `OPENAI_API_KEY`，或在 `application.yaml` 中直接填写。

3. **构建并运行**

```bash
./mvnw spring-boot:run
```

4. **访问接口**
   - 默认服务端口：`8080`
   - 可通过 Postman 或 curl 调用接口

## API 说明

### 1. 新建会话

- **GET** `/ai/connect?type={type}`
- **参数**：type（会话类型，如 chat）
- **返回**：生成的会话 ID

### 2. 聊天接口

- **POST** `/ai/chat`
- **请求体**（JSON）：
  ```json
  {
    "prompt": "你的问题",
    "chatId": "会话ID",
    "files": null
  }
  ```
  - `files` 可选，不传为纯文本对话，传文件为多模态对话

- **返回**：流式文本响应

更多接口详见 `controller`。

## 配置说明

配置文件：`src/main/resources/application.yaml`

- 配置 OpenAI API Key 和模型参数
- 配置数据库路径（详见 `db/db_init.md`）

示例片段：
```yaml
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
      base-url: https://api.gptgod.online/
      chat:
        options:
          model: gpt-4o-mini
  datasource:
    url: jdbc:sqlite:hyproj-ai.sqlite
    driver-class-name: org.sqlite.JDBC
```

## 依赖说明

- Spring Boot 3.5.x
- Spring AI 1.0.x
- SQLite JDBC
- MyBatis-Plus
- Lombok

## 参考文档

- [Spring AI 官方文档](https://docs.spring.io/spring-ai/reference/)
- [Spring Boot 官方文档](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [OpenAI API 文档](https://platform.openai.com/docs/api-reference)

## License

[MIT](LICENSE)

---

如需更多帮助，请访问 [Hyperplasma](https://www.hyperplasma.top)。
