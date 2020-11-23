# Parking
Тестовое задание в отдел разработки РЦР «Казань»

Срок выполнения – 5 дней.

Задание: Создать приложение, эмулирующее автомобильную парковку.
Парковка вмещает конечное число автомобилей. Площадь проездов
между рядами а также расстояние между местами не учитываем.
Принимаем, что вся площадь парковки занята местами, между
которыми автомобили перемещаются методом телепортации.
Автомобили могут быть двух типов: легковые(занимают одно место) и
грузовики(занимают 2 места).

Формат выполнения: Код можно вставить в блокнот, или прислать
ссылку на гит хаб с звданием.

Рабочий процесс парковки: при запуске приложения пользователь вводит
следующие параметры:
- количество парковочных мест
- максимальную длину очереди автомобилей ожидающих въезда на парковку
- интервал генерации входящих автомобилей в секундах
- интервал генерации выходящих автомобилей в секундах

После введения параметров приложение начинает генерировать входные
автомобили и помещать их в очередь. Тип автомобиля выбирается
произвольно, но с учётом того, что грузовых должно быть меньше. Иными
словами, грузовики генерируются реже. Для частоты генерации используется
заданный пользователем интервал. То есть, есть ли мы имеем интервал T1 и
начало работы парковки в момент T0, то в какой-то рандомный момент
времени между T0 &lt; T &lt;= T0 + T1 генерируется автомобиль во входную
очередь. Следующий момент для генерации входящего авто наступит в
интервале T &lt; t &lt; T + T0 и так далее. Аналогично происходит удаление
автомобилей с парковочных мест. То есть, если мы имеем интервал для
удаления авто с парковки T2, то в произвольный момент T0 &lt; T &lt;= T0 + T2
выбирается произвольный автомобиль с парковки и удаляется.

Каждый автомобиль имеет уникальный id. Он может быть любого типа,
главное — уникальность.
Добавление авто во входную очередь и выезд с парковки должны
происходить независимо друг от друга. Каждые 5 секунд парковка сообщает
свою статистику в виде:
- Свободных мест: X
- Занятно мест: Y(из них столько-то легковых и столько-то грузовых авто)
- Автомобилей, ожидающих в очереди: Z

Информирование о событиях:
При добавлении автомобиля в очередь парковка сообщает
«Легковой/грузовой автомобиль с id = &lt;айдишник авто&gt; встал в очередь на
въезд.»
При перемещении авто на парковку парковка сообщает «Легковой/грузовой
автомобиль с id = &lt;айдишник авто&gt; припарковался.»
При выезде авто с парковки она сообщает об этом «Легковой/грузовой
автомобиль с id = &lt;айдишник авто&gt; покинул парковку.»

Как парковка себя ведёт в разных ситуациях:
- Если мест не осталось, то генерация во входную очередь не прекращается.
- Если входная очередь достигла заданного максимума, то происходит
carmageddon и парковка завершает работу с каким-нибудь «alarm» -
сообщением. Выход из приложения.

Приложение должно иметь консольный интерфейс, никакой GUI не
требуется. Использование субд и внешних файлов не требуется, все данные
храним в памяти. Структуры данных и инструменты работы с потоками на
ваше усмотрение. Для написания кода ожидается использование Java версии
не выше 8. Задание должно быть представлено в виде проекта для Intellij
Idea.