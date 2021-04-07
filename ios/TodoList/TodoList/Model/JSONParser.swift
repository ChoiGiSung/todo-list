//
//  JSONDecoder.swift
//  TodoList
//
//  Created by Jun Ho JANG on 2021/04/06.
//

import Foundation

class JSONParser {
    
    static func parseData(data: Data) -> ToDoItem? {
        let decoder = JSONDecoder()
        do {
            let result = try decoder.decode(ToDoItem.self, from: data)
            return result
        } catch {
            print(error.localizedDescription)
            return nil
        }
    }
    
}