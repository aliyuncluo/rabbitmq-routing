# rabbitmq-routing
rabbitmq的路由模式

路由模式（Routing）
P发送消息到交换机并且要指定Routngkey，消费者将队列绑定到交换机时需要指定Bindingkey。然后相应的消费者就能监听到消息。

![图片说明](https://github.com/aliyuncluo/rabbitmq-routing/blob/master/20180405185615945.png)

项目结构：
队列1：one-queue --->routingKey "user","role"
队列2：two-queue --->routingKey "order","sale"

生产者根据选择输入的routingKey，和message,发送消息到交换机direct_exchange中，然后根据绑定的队列和routingKey，对应的消费者才能监听到对象的消息。
必须明确：队列和具体的routingKey.
