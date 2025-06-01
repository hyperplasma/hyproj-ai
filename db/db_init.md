Choose whatever database to store the Hyplus Service data.

For convenience, you can manually create a SQLite database file: `hyproj-ai.sqlite` .

Then execute the following script in the SQLite console:

```sqlite
-- Initialization script for SQLite database: hyproj-ai.sqlite

CREATE TABLE IF NOT EXISTS course (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,         -- 课程名称
    edu INTEGER,                -- 学历要求
    type TEXT,                  -- 课程类型，匹配学生兴趣
    price INTEGER,              -- 课程价格
    duration INTEGER,            -- 课程时长，单位为天
    description TEXT             -- 课程描述
);

CREATE TABLE IF NOT EXISTS course_reservation (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    course TEXT NOT NULL,       -- 课程名称或 ID
    student_name TEXT NOT NULL, -- 学生姓名
    contact_info TEXT,          -- 联系方式
    school TEXT,                -- 学校名称
    remark TEXT                 -- 备注
);

CREATE TABLE IF NOT EXISTS school (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,         -- 学校名称
    city TEXT,                  -- 所在城市
    address TEXT,               -- 地址
    email TEXT,                 -- 邮箱
    website TEXT,               -- 网站
    description TEXT            -- 描述
);

INSERT INTO course (name, type, edu, duration, price, description) VALUES
('Python网络爬虫实战', '编程', 2, 30, 299, '从零开始学习网络爬虫，掌握数据采集技术'),
('Java企业级开发', '编程', 4, 60, 599, '企业级应用开发，包含Spring全家桶实战'),
('UI设计入门到精通', '设计', 2, 45, 399, '掌握UI设计基础，快速上手界面设计'),
('短视频内容创作', '自媒体', 1, 20, 199, '短视频策划、拍摄与剪辑技巧'),
('数据结构与算法进阶', '编程', 4, 50, 499, '计算机核心课程，着重算法分析与设计'),
('品牌视觉设计', '设计', 3, 40, 449, '品牌形象设计，包含VI系统设计实践'),
('新媒体运营实战', '自媒体', 3, 35, 349, '全方位新媒体运营技能培训'),
('人工智能基础', '编程', 5, 55, 699, '机器学习和深度学习核心概念与实践'),
('3D建模基础', '设计', 2, 48, 479, '3D模型制作与渲染技术教程'),
('直播带货技巧', '自媒体', 0, 15, 149, '直播技巧与带货实战指南'),
('区块链开发', '编程', 4, 45, 599, '区块链应用开发与智能合约编程'),
('产品包装设计', '设计', 3, 38, 429, '商业产品包装设计与制作'),
('抖音短视频运营', '自媒体', 2, 25, 249, '抖音平台运营与内容创作策略'),
('网络安全基础', '其他', 4, 40, 499, '网络安全原理与防护技术实践'),
('项目管理PMP', '其他', 4, 50, 599, '专业项目管理认证课程');

INSERT INTO course_reservation (course, student_name, contact_info, school, remark) VALUES
('Java 基础课程', '张三', '123456789', '清华大学', '无'),
('Python 数据分析', '李四', '987654321', '北京大学', '需要周末上课'),
('机器学习入门', '王五', '456123789', '复旦大学', '希望提供更多案例'),
('Web 开发入门', '赵六', '789456123', '上海交通大学', '无'),
('数据库设计', '孙七', '321654987', '浙江大学', '无'),
('算法与数据结构', '周八', '654987321', '南京大学', '需要更多练习题'),
('前端开发', '吴九', '987321654', '中山大学', '无'),
('后端开发', '郑十', '123789456', '华中科技大学', '无'),
('大数据分析', '钱十一', '456789123', '哈尔滨工业大学', '无'),
('人工智能高级课程', '冯十二', '789123456', '西安交通大学', '无'),
('网络安全基础', '陈十三', '321987654', '同济大学', '无'),
('云计算入门', '褚十四', '654321987', '北京航空航天大学', '无'),
('区块链技术', '卫十五', '987654321', '北京理工大学', '无'),
('C++ 高级编程', '蒋十六', '123456789', '天津大学', '无'),
('操作系统原理', '沈十七', '456123789', '东南大学', '无'),
('计算机网络', '韩十八', '789456123', '武汉大学', '无'),
('软件工程', '杨十九', '321654987', '华南理工大学', '无'),
('数据挖掘', '朱二十', '654987321', '重庆大学', '无'),
('深度学习', '秦二十一', '987321654', '四川大学', '无'),
('自然语言处理', '尤二十二', '123789456', '电子科技大学', '无');

INSERT INTO school (name, city, address, email, website, description) VALUES
('未来学园教程阅览所', '北京', '朝阳区望京SOHO T1-2801', 'future@hyplus.com', 'https://future.hyplus.com', '专注于AI与编程领域的现代化教程阅览设施，配备高性能工作站'),
('极光科技教程中心', '上海', '浦东新区张江高科技园区88号', 'aurora@hyplus.com', 'https://aurora.hyplus.com', '提供最新科技领域教程研习环境，设有VR实验室'),
('数字港湾学习空间', '深圳', '南山区科技园南区T2栋', 'digitalport@hyplus.com', 'https://port.hyplus.com', '24小时开放的科技教程阅览环境，配备智能辅导系统'),
('创想谷教程基地', '杭州', '西湖区浙大科技园A3-501', 'valley@hyplus.com', 'https://valley.hyplus.com', '集教程阅览、实践和交流于一体的综合性场所'),
('智汇云教程空间', '成都', '高新区天府软件园C区', 'smart@hyplus.com', 'https://smart.hyplus.com', '云计算和大数据特色教程基地，配备专业机房'),
('创新方舟学习中心', '武汉', '东湖新技术开发区光谷软件园', 'ark@hyplus.com', 'https://ark.hyplus.com', '强调实践创新的教程阅览基地，设有创客空间'),
('极客空间', '广州', '天河区珠江新城CBD', 'geek@hyplus.com', 'https://geek.hyplus.com', '为极客打造的24小时教程研习空间，提供专业技术支持'),
('代码工坊', '南京', '建邺区奥体CBD', 'code@hyplus.com', 'https://code.hyplus.com', '专注编程技术的教程阅览所，配备协作编程环境'),
('量子学习中心', '西安', '高新区软件新城', 'quantum@hyplus.com', 'https://quantum.hyplus.com', '前沿科技教程阅览基地，设有量子计算实验室'),
('开源谷教程中心', '青岛', '崂山区青岛软件园', 'opensource@hyplus.com', 'https://opensource.hyplus.com', '开源技术教程分享空间，强调社区协作');
```