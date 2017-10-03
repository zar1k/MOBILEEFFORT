/**
 * Программа выполняет подсчет количества файлов в папке и всех ее подпапках. Папки, в
 * которых необходимо выполнять поиск, заданы в файле, который передается первым
 * аргументом командной строки.
 * <p>
 * Работа по подсчету выполняется одновременно по каждой папке из файла входных
 * данных, и результаты фиксируются сразу по каждому из путей.
 * <p>
 * Результаты записываются после окончания поиска по своей папке в файл, который
 * передается вторым аргументом консольному приложению, и на экран.
 * <p>
 * Во входном файле содержится одна или больше строк-путей. Каждая из строк – это папка,
 * которая требует подсчета в ней файлов.
 * <p>
 * Выходной файл должен быть в формате CSV с разделителем точка с запятой (;). Первая
 * колонка – это исходный путь из входного файла, вторая – количество файлов в папке.
 * Вывод на экран должен быть представлен в табличном виде. Первая колонка – это
 * порядковый номер записи, вторая колонка – количество найденных файлов, третья –
 * исходный путь для поиска.
 * <p>
 * Пользователь должен иметь возможность отменить запущенные поиски нажатием клавиши
 * Esc. При этом на экране должны отобразиться результаты собранных данных на этот
 * момент.
 *
 * @author <a href="mailto:andreyzarazka@gmail.com">Andrew Zarazka</a>
 * @since 18.07.2016
 */
package com.mobileffort;